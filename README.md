# wallet
To run the code, use following commands:
$ git clone 
$ cd wallet
$ java -jar target/wallet-0.0.1-SNAPSHOT.jar

To recompile from root :
$ mvn clean
$ mvn install

Following are some curl commands that can be used :

curl -H "Content-Type: application/json" -XPOST --data '{"name": "Abdul","email": "m@b.com"}' http://127.0.0.1:8080/admin/adduser

curl -H "Content-Type: application/json" -XPOST --data '{"amount":100.00,"user":{"id":4 , "key":""},"promocode":"SALTSIDE"}' http://127.0.0.1:8080/add

curl -H "Content-Type: application/json" -XPOST --data '{"amount":5.00,"user":{"id":4 , "key":""}}' http://127.0.0.1:8080/use

curl http://localhost:8080/admin/getallusers

curl http://localhost:8080/admin/getalltx

curl http://localhost:8080/passbook/4

http://localhost:8080/getbalance/4

