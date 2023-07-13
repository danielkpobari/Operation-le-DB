
## **This project stores image directly into the Database.**

-for uploads it compresses the image and stores it in the database.
-for downloads it decompresses the image and displays it.

**Technologies used**: Spring Boot, Spring Data JPA, MySQL, Maven.

**Steps to run the project**:
step 1: Clone the project.
step 2: Create a database in MySQL.
step 3: Change the database name, username and password in application.properties file.
step 4: Run the project.

**APIs**:
1. Upload Image: 
   - URL: http://localhost:8085/image/upload
   - Method: POST
   - Body: form-data
   - Key: image
   - Value: select an image(jpeg) file
   - Response: Image uploaded successfully.
   - Note: The image will be compressed and stored in the database.
   - Note: The image will be stored in the database in the form of a byte array.
2. Download Image:
    - URL: http://localhost:8085/image/imageName
    - Method: GET
    - Response: The image will be displayed in the browser.
    - Note: The image will be decompressed and displayed in the browser.
    - Note: The image will be fetched from the database in the form of a byte array.
    - Note: The image name should be the same as the one uploaded.
3. Postman Documentation: https://documenter.getpostman.com/view/23166862/2s946chuof
