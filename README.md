# Citibox Financial Loan App - Java Servlet

This web app allows a user to sign-in/register through their Box account. After log in, the user has the ability to upload files to 


**Login/Registration:**

The user must first log in to their Box account to obtain an application authorization code. This authorization allows the user to sync their Box account to the Citibox web app. After application registration, a new folder called "CitiboxFinancial" will be created in the root of the user's Box account.


**Apply For a Loan:**

This page allows the user to input loan relevant information and upload a pdf of "financial documents". When the user submits this information, a loan request folder is created in their personal "CitiboxFinancial" folder. The financial document pdf is then uploaded into this newly created loan request folder. Finally, Citibox Financial is added as a collabotor to this folder. This allows Citibox to review the user's loan request.


**Loan Request History:**

This page will fetch each of the user's loan requests and display the financial documents along with the loan status. This page has not been implemented using Box's view API. Instead, sample documents and statuses are display on this page.

## Web App URL

https://citiboxfinancial.herokuapp.com

## Citibox Financial Box Account Information

The Box email/password listed below can be used to verify the collaboration folders.

**Email:** citiboxfinancial@gmail.com
**Password:** citibox123


