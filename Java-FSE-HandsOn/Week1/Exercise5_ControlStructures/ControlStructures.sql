BEGIN
    FOR cust IN (
        SELECT CustomerID, Age, LoanInterestRate
        FROM Customers
    )
    LOOP
        IF cust.Age > 60 THEN
            UPDATE Customers
            SET LoanInterestRate = LoanInterestRate - 1
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Loan discount applied.');
END;
/
BEGIN
    FOR cust IN (
        SELECT CustomerID, Balance
        FROM Customers
    )
    LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('VIP customers updated.');
END;
/
BEGIN
    FOR loan_rec IN (
        SELECT CustomerID, LoanID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ' || loan_rec.CustomerID ||
            ' has Loan ' || loan_rec.LoanID ||
            ' due on ' || loan_rec.DueDate
        );
    END LOOP;
END;
/