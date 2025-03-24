```toml
name = 'update'
method = 'PUT'
url = 'http://localhost:8080/product/1'
sortWeight = 5000000
id = '6d697c71-d7d7-451f-8b8f-e414477e5a94'

[body]
type = 'JSON'
raw = '''
{
  "id": 1,
  "name": "Dr Pepper",
  "code": "DP",
  "description": "Une bouteille de 1L de Dr Pepper",
  "price": 2,
  "state": {
    "id": 1,
    "name": "full"
  },
  "labels": [
    {
      "id": 3,
      "name": "promo"
    }
  ]
}'''
```
