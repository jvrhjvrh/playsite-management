# Play site management system

Using Java 17.\
This application allows you to create play sites and add kids to them.

Available play sites:
* DOUBLE_SWING
* CAROUSEL
* SLIDE
* BALL_PIT

It's possible to create kids and then add them to
play sites or create them directly on the play site.\
It's also possible to see each play site utilization
and visitor count and a sum of all visitor counts
of all play sites.

Endpoints Available:
* /playsite GET
* /playsite POST
* /playsite/remove-kid/{kidId} PUT
* /playsite/visitors GET
* /playsite/{id} GET
* /playsite/{id}/add-kid POST
* /kid GET
* /kid POST
* /kid/{id} GET

