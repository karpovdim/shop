Domain model:

    ● Product +

    ● Category +

    ● Price +


Relations:

    ● Product can have many or many Categories. +

    ● Categories can have 0 or many Products. +

    ● Product must have one or many Prices. +

    ● Category can have sub category or parent category. +


Implement a backoffice application which support:

    ● Pagination

    ● Search:

        o Product

            ▪ By code (unique) +

            ▪ By name +

            ▪ By price +

            ▪ By category code +

            ▪ By currency +

            ▪ By price range (from 100$ to 200$) +

        o Category

            ▪ By code (unique) +

            ▪ By name +

    ● CRUD operations for all entities (Create, read, update, delete)

    ● Basic auth for REST endpoints


Application should expose REST API to perform operations above (JSON format).
All endpoints should be secured. Provide tests for verifying functionality for
all application layers from DAO to controllers. 
At least 100 products and categories should be generated.
