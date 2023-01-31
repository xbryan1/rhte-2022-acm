podman build -t jclaret/chatdraw .
podman push jclaret/chatdraw quay.io/jclaret/chatdraw:latest

cp templates/index.html templates/index.html_original
cp templates/index.html_red templates/index.html
podman build -t jclaret/chatdraw .
podman push jclaret/chatdraw quay.io/jclaret/chatdraw:rhte2023
cp templates/index.html_original templates/index.html
