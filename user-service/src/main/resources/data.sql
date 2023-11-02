

-- Users Default Insertions --

INSERT INTO USERS (ID, DOB, EMAIL_ID, FIRST_NAME, GENDER, LAST_NAME, PASSWORD, PHONE_NUMBER, ROLE, APPLICANT_DETAILS) VALUES 
(1111, '2000-01-01', 'admin@gmail.com', 'Admin', 'Male', 'Admin', '@dmin@123', 9999999999, 'ROLE_ADMIN', null),
(1112, '2004-04-21', 'user@gmail.com', 'User', 'Male', 'User', 'Xser@123', 8888888888, 'ROLE_USER', null),
(1113, '1999-01-31', 'dummy@gmail.com', 'Dummy', 'Male', 'User', 'Xummy@123', 7777777777, 'ROLE_USER', null);


-- Dummy Reference Details --

INSERT INTO REFERENCE_DETAILS (REFERENCE_NAME, ADDRESS, TELEPHONE_NUMBER) VALUES
('Dummy_Reference', 'GowliDoody', 9876543211);


-- Dummy Address Details --

INSERT INTO ADDRESS_DETAILS  (ID, CITY, DISTRICT, EMAIL_ID, HOUSE_NO, PIN_CODE, STATE, STREET_NAME, TELEPHONE_NUMBER) VALUES
(1111, 'Hyderabad', 'Gachibowli', 'dummy@gmail.com', '1-1-22', 500032, 'Telangana', 'GowliDoody', 9887654321);


-- Dummy Applicant Details --

INSERT INTO APPLICANT_DETAILS  (FIRST_NAME, DISTRICT, EDUCATIONAL_QUALIFICATION, EMPLOYMENT_TYPE, FATHER_NAME, GENDER, MARITAL_STATUS, MOTHER_NAME, PAN, PLACE_OF_BIRTH, STATE, ADDRESS_DETAILS_ID, REFERENCE_DETAILS) VALUES
('Dummy', 'Gachibowli', 'B.Tech', 'Full-Time', 'Dummy`s Father', 'Male', 'Single', 'Dummy`s Mother', 'GPP2930KL', 'Hyderabad', 'Telangana', 
SELECT ID FROM ADDRESS_DETAILS WHERE ID = 1111,
SELECT REFERENCE_NAME FROM REFERENCE_DETAILS WHERE REFERENCE_NAME = 'Dummy_Reference');


-- Updating Dummy User Applicant Details --

UPDATE USERS SET APPLICANT_DETAILS = SELECT FIRST_NAME FROM APPLICANT_DETAILS 
WHERE FIRST_NAME = 'Dummy' WHERE FIRST_NAME = 'Dummy';














