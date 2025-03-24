```toml
name = 'create'
method = 'POST'
url = 'http://localhost:8080/product'
sortWeight = 3000000
id = '59ca1fdd-7d9e-48db-abbc-80011974293b'

[body]
type = 'JSON'
raw = '''
{
  "name": "Sprite",
  "code": "SPR",
  "description": "Une bouteille de 1L de Sprite",
  "price": 2
}'''
```
