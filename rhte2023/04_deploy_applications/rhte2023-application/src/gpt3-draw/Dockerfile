# podman build -t jclaret/chatdraw .
# podman push jclaret/chatbot quay.io/jclaret/chatdraw
FROM python:3.8-slim-buster

COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

RUN mkdir -p /app/templates
RUN mkdir -p /app/static/images
COPY static/images/redhat.png /app/static/images
COPY templates/index.html /app/templates
COPY app.py /app/

EXPOSE 8001

CMD ["python", "/app/app.py"]

