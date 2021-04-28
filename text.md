```html
<link rel="stylesheet" type="text/css" th:href="@{/user/css/bootstrap.min.css}">
  <link rel="stylesheet" type="text/css" th:href="@{/user/css/style.css}">
  <link rel="stylesheet" type="text/css" th:href="@{/user/css/font-awesome.min.css}">
  <link rel="apple-touch-icon-precomposed" th:href="@{/user/images/icon/icon.png}">
  <link rel="shortcut icon" th:href="@{/user/images/icon/favicon.ico}">
  <script th:src="@{/user/js/jquery-2.1.4.min.js}"></script>
  <!--[if gte IE 9]>
  <script th:src="@{/admin/js/jquery-1.11.1.min.js}" type="text/javascript"></script>
  <script th:src="@{/admin/js/html5shiv.min.js}" type="text/javascript"></script>
  <script th:src="@{/admin/js/respond.min.js}" type="text/javascript"></script>
  <script th:src="@{/admin/js/selectivizr-min.js}" type="text/javascript"></script>
  <![endif]-->
```

```html
<script th:src="@{/user/js/bootstrap.min.js}"></script>
<script th:src="@{/user/js/admin-scripts.js}"></script>
```

```html
<section class="container-fluid">
  <div th:replace="~{common/common::topbar}"></div>
  <div class="row">
    <div th:replace="~{common/common::sidebar}"></div>
```