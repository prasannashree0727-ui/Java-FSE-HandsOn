CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed.');
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE Department = dept_name;

    DBMS_OUTPUT.PUT_LINE('Employee bonus updated.');
END;
/BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/CREATE OR REPLACE PROCEDURE TransferFunds(
    from_acc IN NUMBER,
    to_acc IN NUMBER,
    amount IN NUMBER
) AS
    current_balance NUMBER;
BEGIN
    SELECT Balance INTO current_balance
    FROM Accounts
    WHERE AccountID = from_acc;

    IF current_balance >= amount THEN

        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = from_acc;

        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = to_acc;

        DBMS_OUTPUT.PUT_LINE('Transfer successful.');

    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
END;
/BEGIN
    TransferFunds(101, 102, 500);
END;
/