#!/bin/bash
cd "$(dirname "$0")"  # 스크립트 위치로 이동
if [ ! -d "venv" ]; then
  echo "⚙️  venv not found, creating new virtual environment..."
  python3 -m venv venv
fi

source venv/bin/activate
echo "🐍  Virtual environment activated!"
echo "(venv) path: $(which python3)"

