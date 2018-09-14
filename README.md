# XRest_project

**BUILD'n'RUN project:**

- For Unix:

1) Open a project's main folder in a terminal.
2) Use a command: `./mvnw spring-boot:run`.

<br/>

- For Windows:

1) Open a project's main folder in a console.
2) Use a command: `.\mvnw.cmd spring-boot:run`.
<br><br>

**EndPoints:**<br>
   `GET/status/ping`: we'll get "pong"<br>
<hr>

   `POST/numbers/sort-command`: <br>
   1. Send JSON: { "numbers": [numbers to sort], "order": "ASC"/"DESC" } .<br>
   2. We'll get: { "numbers": [sorted numbers] } .<br>
<hr>

   `POST/currencies/get-current-currency-value-command`:<br>
   1. Send JSON: { "currency": "_currency code (standard ISO 4217)_" } .<br>
   2. We'll get: { "value": currency value } .<br>
   Currency value is downloaded from <a href="http://api.nbp.pl">`api.nbp.pl`</a>.