# Bus ninjas wednesday pitching session

## Setup

In your Python 3 virtual environment:

    pip install -r requirements.txt
    cat api_key = \"BRISTOL_API_KEY\" >> config.toml

## Deploy flask server:

    python app

## Test suite:

    python setup.py test

## Configuring nginx server:

In nginx (based on http://flask.pocoo.org/snippets/35/):

    location /bus {
        proxy_pass http://127.0.0.1:5000;
        proxy_set_header Host $host;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Scheme $scheme;
        proxy_set_header X-Script-Name /bus;
        }
