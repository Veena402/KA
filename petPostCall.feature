Feature:
  Background:
    * def serviceURL = 'https://petstore.swagger.io/v2/pet'

#    Assignment 3 AND 4
  Scenario Outline:Using POST CALL , Create PET with URL = https://petstore.swagger.io/v2/pet  &Match Pet ID , Pet Name and Status coming from response
    Given url serviceURL
    * def javaFileObj = Java.type('reuseMethod.ReadingCommonMethod')
    * def requestJsonBody  = javaFileObj.createJsonBody('<id>','<name>')
    * def petId = '<id>'
    * def petName = '<name>'

    When request requestJsonBody
    Then method post
    Then status 201
    And print 'Response is; ' , response
    And match response.id == parseInt(petId)
    And match response.name == petName
    And match response.status == 'available'

    Examples:
      |id |name|
      |31|Pig|
      |32|Cat|
      |100|Tiger|

#Assignement 5 USING GET CALL , validate PET is created using URL = https://petstore.swagger.io/v2/pet/100 , where make 100 as parameterized as per PET ID
#Assignement 6 Match Pet ID , Pet Name and Status coming from response

  Scenario Outline: USING GET CALL , validate PET is created using URL
    Given url serviceURL + '/' + '<petId>'
    When method GET
    Then status 200
    And match response.id == parseInt('<petId>')
    And match response.name == '<petName>'
    And match response.status == 'available'

    Examples:
      |petId|petName|
      | 100   | Tiger   |

#USING DELETE CALL , delete PET using URL = https://petstore.swagger.io/v2/pet/100 , where make 100 as parameterized as per PET ID
  #In Delete call response , validate response.code == 200 , response.message == Pet ID

  Scenario Outline: USING Delete CALL, delete pet using url
    Given url serviceURL + '/' + '<petId>'
    When method DELETE
    Then status 200
    And match response.code == 200
    And match response.message == '<petId>'
    And match response.type == 'unknown'

    Examples:
      | petId |
      | 100   |


