import pytest, importlib, sys, time
from io import StringIO
from utils.timer import measure_time

def get_test_cases():
    import os, json
    DATA_DIR = "tests/data"
    cases = []
    for file in os.listdir(DATA_DIR):
        if not file.endswith(".json"):
            continue
        problem_id = file.replace(".json", "")
        with open(os.path.join(DATA_DIR, file), encoding="utf-8") as f:
            data = json.load(f)
        for idx, case in enumerate(data.get("cases", []), start=1):
            inputs = case.get("inputs", [case.get("input")])
            expected = case["output"].strip()
            joined_input = "\n".join(inputs)
            cases.append(pytest.param(problem_id, idx, joined_input, expected, id=f"{problem_id}#{idx}"))
    return cases


@pytest.mark.parametrize("problem_id,case_no,given,expected", get_test_cases())
def test_dynamic(monkeypatch, capsys, problem_id, case_no, given, expected, request):
    """실제 문제 실행 및 결과 검증"""
    mod = importlib.import_module(f"problems._{problem_id}")
    sys.stdin = StringIO(given)

    start = time.perf_counter()
    mod.solve()
    elapsed = time.perf_counter() - start

    out = capsys.readouterr().out.strip().splitlines()
    # ⏱ 시간 출력 제거
    out = [line for line in out if not line.strip().startswith("⏱")]
    captured = " ".join(out).strip()

    ok = (captured.split() == expected.split())

    # ✅ pytest report에 메타정보 저장
    report_info = {
        "problem_id": problem_id,
        "case_no": case_no,
        "given": given.replace("\n", " / "),
        "expected": expected,
        "captured": captured,
        "elapsed": f"{elapsed:.6f}s",
        "ok": ok,
    }
    request.node.user_properties.append(("report_info", report_info))

    assert ok, f"❌ {problem_id}#{case_no} 실패\n입력: {given}\n기댓값: {expected}\n출력: {captured}\n⏱ {elapsed:.6f}s"


# ============== 커스텀 출력 Hook ==============
def pytest_runtest_logreport(report):
    """각 테스트 실행 후 커스텀 출력"""
    if report.when == "call":  # setup/call/teardown 중 call만
        for prop in report.user_properties:
            if prop[0] == "report_info":
                info = prop[1]
                status = "✅ PASSED" if info["ok"] else "❌ FAILED"
                
                # 출력과 기댓값 비교해서 차이나는 부분 강조
                captured_colored = colorize_diff(info['captured'], info['expected'])
                expected_colored = colorize_diff(info['expected'], info['captured'])
                
                print(f"\n{info['problem_id']}#{info['case_no']} | "
                      f"입력: {info['given']} | "
                      f"출력: {captured_colored} | "
                      f"기댓값: {expected_colored} | "
                      f"⏱ {info['elapsed']} | {status}")


def colorize_diff(text1, text2):
    """두 문자열을 비교해서 다른 부분을 빨간색으로 표시"""
    # ANSI 색상 코드
    RED = '\033[91m'
    RESET = '\033[0m'
    
    words1 = text1.split()
    words2 = text2.split()
    
    result = []
    max_len = max(len(words1), len(words2))
    
    for i in range(max_len):
        word1 = words1[i] if i < len(words1) else ""
        word2 = words2[i] if i < len(words2) else ""
        
        if word1 != word2:
            result.append(f"{RED}{word1}{RESET}" if word1 else f"{RED}(missing){RESET}")
        else:
            result.append(word1)
    
    return " ".join(result)