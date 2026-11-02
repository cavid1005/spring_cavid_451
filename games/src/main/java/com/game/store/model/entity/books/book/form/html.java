<nav>
<h2>My Library</h2>
    <div>
        <a th:href="@{/library/books}">Books</a>
    </div>
</nav>

<main>
    <h1 th:text="${editMode} ? 'Edit Book' : 'Add Book'"></h1>

    <form th:object="${bookRequest}"
th:action="${editMode} ? @{/library/books/{id}/edit(id=${bookId})} : @{/library/books/add}"
method="post">

        <input type="text" th:field="*{title}" placeholder="Enter title">
        <small th:if="${#fields.hasErrors('title')}" th:errors="*{title}"></small>

        <input type="text" th:field="*{genre}" placeholder="Enter genre">
        <small th:if="${#fields.hasErrors('genre')}" th:errors="*{genre}"></small>

        <input type="number" step="0.01" th:field="*{price}" placeholder="Enter price">
        <small th:if="${#fields.hasErrors('price')}" th:errors="*{price}"></small>

        <select th:field="*{authorId}">
            <option value="">Select author</option>
            <option th:each="author : ${authors}"
th:value="${author.id}"
th:text="${author.fullName}"></option>
        </select>
        <small th:if="${#fields.hasErrors('authorId')}" th:errors="*{authorId}"></small>

        <div>
            <button type="submit" th:text="${editMode} ? 'Update Book' : 'Save Book'"></button>
            <a th:href="@{/library/books}">Cancel</a>
        </div>
    </form>
</main>