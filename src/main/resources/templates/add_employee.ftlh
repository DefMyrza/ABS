<h1>Добавить сотрудника</h1>
<form action="/add" method="post">
    <label for="firstName">Имя:</label>
    <input type="text" id="firstName" name="firstName" value="${employee.firstName!}">
    <p>${employee.errors.firstName}</p>


<!-- Остальные поля формы -->

<button type="submit">Сохранить</button>
</form>
