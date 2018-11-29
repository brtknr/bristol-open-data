#!/usr/bin/env python
import os.path

try:
    from setuptools import setup
except ImportError:
    from distutils.core import setup

long_description = ""
with open('README.md') as f:
    long_description = f.read()

with open('requirements.txt') as f:
    requirements = f.read().splitlines()

setup(
    name='bristolapi',
    version=open(os.path.join('bristolapi', 'VERSION')).read().strip(),
    author='Bus Ninjas',
    author_email='b.kunwar@gmail.com',
    packages=['bristolapi'],
    package_data={'bristolapi': ['VERSION']},
    url='https://github.com/brtknr/BristolAPI',
    license='Apache (see LICENSE file)',
    description='Bristol Bus API',
    long_description=long_description,
    python_requires=">=3.6",
    install_requires=requirements,
    test_suite='bristolapi.tests'
)
