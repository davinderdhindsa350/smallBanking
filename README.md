# smallBanking
Small banking Api application for assignment

Create account :
curl --location --request POST 'http://localhost:8080/addAccount' \
--header 'Content-Type: application/json' \
--data-raw '{
    "holderName":"Davinder",
    "holderEmail":"Davinder@gmail.com",
    "balance":"100"

}'

Deposit Money :

curl --location --request PUT 'http://localhost:8080/depositMoney?account_id=1&amount=10'

WithDraw Money:

curl --location --request PUT 'http://localhost:8080/withdrawMoney?account_id=1&amount=10'
