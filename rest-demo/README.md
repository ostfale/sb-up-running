# Setup

## httpie

Needs python to be installed (pip) in powershell with admin rights

```shell
python -m pip install --upgrade pip setuptools
python -m pip install --upgrade httpie
```

Running Commands:

+ GET   `http :8080/coffees`
+ GET   `http :8080/coffees/b4843dd6-ddbf-4dbe-8cd9-9268fd1f9afe`
+ POST  `http :8080/coffees < coffee.json`
+ PUT  `http PUT :8080/coffees/999999 < coffee.json` (id exists - replace)
+ PUT  `http PUT :8080/coffees/888888 < coffee.json` (id exists not - create)
+ DELETE `http DELETE :8080/coffees/999999`
