#!/usr/bin/env python3

from flask import Flask, render_template, url_for
from flask import request
from flask_restful import Resource, Api
from bristolapi import BristolApi
import json
import toml

config = toml.load('config.toml')
bapi = BristolApi(config)
app = Flask(__name__, static_url_path='/static')
api = Api(app)

@app.route('/')
def root():
    print (url_for('static', filename='app.js'))
    return render_template('index.html')

@app.route('/routes')
def routes():
    return json.dumps(bapi.get_stops(BristolAPI.route_75))

@app.route('/report')
def report():
    pass

app.run(debug=True)
