#syntax=docker/dockerfile:1.4

FROM python:3.11-slim

RUN useradd -m dockeruser &&  \
    mkdir -p /app && \
    chown -R dockeruser:dockeruser /app

WORKDIR /app

COPY requirements.txt .

RUN --mount=type=cache,target=/root/.cache/pip \
    pip install --no-cache-dir -r requirements.txt

USER dockeruser

RUN --mount=type=secret,id=mykey \
    curl -H "Authorization: Bearer $(cat /run/secrets/mykey)" \
    https://api.example.com/private

COPY app.py .
ENTRYPOINT ["python3", "app.py"]