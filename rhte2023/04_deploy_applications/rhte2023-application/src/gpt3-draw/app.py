# https://github.com/blessinvarkey/gpt3-flask-bot
from flask import Flask, render_template, request
import os
import openai
from time import time,sleep
import base64
from IPython.display import display
from PIL import Image


app = Flask(__name__)
app=Flask(__name__,template_folder='templates')
app = Flask(__name__, static_url_path='/static')

# Create an openaiapikey.txt file and save your api key.
openai.api_key = "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"

def bot(prompt, size="1024x1024", n=1, response_format="b64_json"):
    max_retry = 1
    retry = 0
    while True:
        try:
            response = openai.Image.create(
                prompt = prompt,
                size = "1024x1024",
                n = 1,
                response_format = "url"
            )

            text = response["data"][0]["url"]
            print(text)
            return text

        except Exception as oops:
            retry += 1
            if retry >= max_retry:
                return "GPT3 error: %s" % oops
            print('Error communicating with OpenAI:', oops)
            sleep(1)


@app.route("/")
def home():
    return render_template("index.html")

@app.route("/get")
def get_bot_response():
    userText = request.args.get('msg')
    botresponse = bot(prompt =userText)
    return str(botresponse)

if __name__ == "__main__":
    app.run(debug = True,host='0.0.0.0',port=8001)
