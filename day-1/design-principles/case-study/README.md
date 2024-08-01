**Case Study: Library Management System**
---

The case study highlights the importance of modular and focused design principles for software development. The questions encourage participants to think about how applying the Single Responsibility Principle and the Open/Closed Principle can enhance the maintainability and extensibility of a software system.

**Time:** 40 minutes

---

**Background:**
You are part of a team developing a Library Management System for a local library. The system allows librarians to manage books, patrons, and borrowing activities. The system has evolved over time, but the codebase has become challenging to maintain.

**Scenario:**
In the current implementation:

1. The `Book` class handles both book information and book availability status.
2. The `Patron` class manages both patron details and patron borrowing history.
3. The `Library` class contains methods for managing books and patrons, as well as handling borrowing and returning operations.

As the team reviews the code, they observe the following issues:

1. The `Book` class is responsible for both book data and availability logic, violating the Single Responsibility Principle (SRP).
2. The `Patron` class combines patron information and borrowing history, leading to increased complexity and reduced maintainability.
3. The `Library` class handles multiple responsibilities, making it harder to extend the system without modifying existing code, which violates the Open/Closed Principle (OCP).

**Questions:**

1. **Explain the Single Responsibility Principle (SRP) and why it's important in software design.**

2. **In what ways does the `Book` class violate the Single Responsibility Principle (SRP)?**

3. **How can the `Book` class be refactored to adhere to the Single Responsibility Principle (SRP)?**

4. **What issues can arise from combining patron details and borrowing history in the `Patron` class?**

5. **How can the `Patron` class be redesigned to follow the Single Responsibility Principle (SRP)?**

6. **What is the Open/Closed Principle (OCP) and why is it beneficial for software systems?**

7. **Explain why the `Library` class's design violates the Open/Closed Principle (OCP).**

8. **Suggest a design approach that adheres to the Open/Closed Principle (OCP) for the `Library` class, allowing for future extensions without modifying existing code.**

9. **Provide a high-level explanation of how applying the Single Responsibility Principle (SRP) and the Open/Closed Principle (OCP) can improve the Library Management System's codebase.**

---