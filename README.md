# Currency-converter

### How to run
- Add api key for `https://api.exchangeratesapi.io/` into `application.yml` file
- cd into project root directory and run following command
`./gradlew bootRun`

API end point

- Valid Endpoint
`http://localhost:8080/currency/covert/amount/20/from/EUR/to/BDT`

- Response
```
1,930.46

```

- Invalid Endpoint


`GET http://localhost:8080/currency/covert/amount/20/from/EUR/to/BDTT`

- Response
```
HTTP/1.1 400 Bad Request
Content-Type: application/json
Content-Length: 109

{
  "message": "Invalid toCurrency : BDTT",
  "httpStatus": "BAD_REQUEST",
  "timestamp": "2021-11-23T15:27:36.9715916Z"
}

Response code: 400 (Bad Request); Time: 125ms; Content length: 109 bytes
```

- Code deployed in `heroku` 
- Use following curl command to get result from `heroku`
```
curl --location --request GET 'http://demo-app-sazzad.herokuapp.com/currency/covert/amount/20/from/EUR/to/BDT'
```
