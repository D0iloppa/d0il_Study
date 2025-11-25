import time
from functools import wraps
from rich.console import Console

console = Console()

def measure_time(func):
    @wraps(func)
    def wrapper(*args, **kwargs):
        start = time.perf_counter()
        result = func(*args, **kwargs)
        end = time.perf_counter()
        console.print(f"[bold cyan]⏱ {end - start:.6f}s elapsed[/bold cyan]")
        return result
    return wrapper
