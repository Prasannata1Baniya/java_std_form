<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success</title>
    <style>
        body { 
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%); 
            display: flex; 
            justify-content: center; 
            align-items: center; 
            min-height: 100vh; 
            margin: 0; 
            font-family: 'Segoe UI', sans-serif; 
        }
        .card { 
            background: white; 
            padding: 2.5rem; 
            border-radius: 10px; 
            box-shadow: 0 10px 25px rgba(0,0,0,0.1); 
            text-align: center; 
            max-width: 400px; 
            width: 90%; 
        }
        .icon { font-size: 3.5rem; color: #2ecc71; margin-bottom: 1rem; }
        h2 { color: #2c3e50; margin: 0 0 0.5rem 0; }
        p { color: #7f8c8d; margin-bottom: 1.5rem; }
        .btn { 
            display: inline-block; 
            padding: 0.75rem 1.5rem; 
            background-color: #4a90e2; 
            color: white; 
            text-decoration: none; 
            border-radius: 5px; 
            font-weight: 600; 
        }
    </style>
</head>
<body>
  <div class="card">
    <div class="icon">✓</div>
    <h2>Success!</h2>
    <p>The company data has been successfully saved to your database.</p>
    <a href="index.html" class="btn">Go Back to Form</a>
  </div>
</body>
</html>