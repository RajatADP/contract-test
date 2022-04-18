import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        urlPath('/credit-scores')
        body """
        {
            "citizenNumber" : 1
        }
        """
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        body """
        {
            "score" : "HIGH"
        }
        """
        headers {
            contentType(applicationJson())
        }
    }
}