# RewardsCalculator


# Calculate Customer Reward Points
#####This rest API serves the purpose of getting customer rewards based on customer Id


- Exception is thrown if customer does not exists with the given customerId.
- H2 in-memory database to store the transaction information.
- Install H2 db locally and run it . change the db settings in application.properties file.
- Do run the data.sql on H2 in memory DB to prepare the test data.


Steps To RUN : 
Clone this project and run RewardsApplication.java and then call the below endpoint
```
 http://localhost:8080/customer/{customerId}/rewards
```

