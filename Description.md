# Program Description: Draft Ticket Price Calculator for Travel Agencies

## Overview
This program is designed to calculate draft ticket prices for travel agencies based on passenger information and luggage details. To obtain a draft ticket price, the following data must be provided:

## Data Inputs
1. **List of Passengers**: A list of passengers, each represented by two attributes:
    - `isAdult` (boolean): Indicates whether the passenger is an adult (true) or a child (false).
    - `bags` (integer): Specifies the number of luggage items carried by the passenger.

## Web Services
The program offers three web services to handle this data. Here's how the workflow operates:

### Ticket Service
- Receives a JSON structure representing an array of passenger objects.
- Each passenger object contains information about whether they are an adult and the number of luggage items they have.

#### Example Request
```json
[
  {
    "isAdult": true,
    "bags": 2
  },
  {
    "isAdult": false,
    "bags": 1
  }
]
```
#### Response Structure
- The service processes the data and returns a JSON structure containing two main components:
  A list of individual ticket details, including formatted ticket texts and ticket prices.
  The total amount to be paid for all tickets.
#### Example Response
```json
{
  "tickets": [
    {
      "ticketText": "Adult (10 EUR + 21%) = 12.10 EUR",
      "ticketPrice": 12.10
    },
    {
      "ticketText": "Two bags (2 x 10 EUR x 30% + 21%) = 7.26 EUR",
      "ticketPrice": 7.26
    },
    {
      "ticketText": "Child (10 EUR x 50% + 21%) = 6.05 EUR",
      "ticketPrice": 6.05
    },
    {
      "ticketText": "One bag (10 EUR x 30% + 21%) = 3.63 EUR",
      "ticketPrice": 3.63
    }
  ],
  "total": 29.04
}

```
#### Ticket Generation
For each passenger, two types of tickets can be generated:

- A ticket for the passenger based on their age category (adult/child).
- A luggage ticket, if the passenger has luggage items.
#### External Services
The program provides flexibility by allowing the configuration of external services for obtaining base prices and tax percentages.
These services can be replaced by specifying the respective URLs in the application.properties file.