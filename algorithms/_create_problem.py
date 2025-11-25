#!/usr/bin/env python3
import sys
import shutil
import os
import json

def main():
    if len(sys.argv) < 2:
        print("❗ Usage: python create_problem.py <problem_id>")
        sys.exit(1)

    problem_id = sys.argv[1]
    base_dir = os.path.dirname(os.path.abspath(__file__))

    # 경로 설정
    template_path = os.path.join(base_dir, "template", "algo_template.py")
    problem_dir = os.path.join(base_dir, "problems")
    test_data_dir = os.path.join(base_dir, "tests", "data")

    # 파일명 설정
    problem_path = os.path.join(problem_dir, f"_{problem_id}.py")
    test_json_path = os.path.join(test_data_dir, f"{problem_id}.json")

    # 디렉토리 확인
    os.makedirs(problem_dir, exist_ok=True)
    os.makedirs(test_data_dir, exist_ok=True)

    # 템플릿 복사
    if not os.path.exists(template_path):
        print(f"❌ Template not found: {template_path}")
        sys.exit(1)

    shutil.copy(template_path, problem_path)
    print(f"✅ Created problem file: {problem_path}")

    # JSON 생성
    if not os.path.exists(test_json_path):
        default_case = {
            "cases": [
                {
                    "inputs": ["5 21", "5 6 7 8 9"],
                    "output": "1 0 0 0 0 1"
                }
            ]
        }
        with open(test_json_path, "w", encoding="utf-8") as f:
            json.dump(default_case, f, indent=2, ensure_ascii=False)
        print(f"✅ Created test JSON: {test_json_path}")
    else:
        print(f"⚠️  Test JSON already exists: {test_json_path}")

    print("🎉 Problem setup complete!")

if __name__ == "__main__":
    main()
