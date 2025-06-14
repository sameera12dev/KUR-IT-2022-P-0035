<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Login Page</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-screen w-screen bg-gray-100 flex items-center justify-center">

  <div class="flex w-full h-full">
    
    <!-- Left Side: Login Form -->
    <div class="w-1/2 bg-white flex flex-col justify-center px-20 py-10">
      <h2 class="text-3xl font-bold mb-2">Sign in <span class="text-xl">😊</span></h2>
      <p class="mb-6 text-sm text-gray-600">
        Don't have an account? <a href="#" class="text-blue-500 font-semibold">Create now</a>
      </p>
      <form id="loginForm">
        <input id="email" type="email" placeholder="E-mail" class="w-full mb-4 px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400" />
        
        <div class="relative mb-4">
          <input id="password" type="password" placeholder="Password" class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400" />
          <button type="button" id="togglePassword" class="absolute right-2 top-2 text-xs text-blue-500">Show</button>
        </div>

        <div class="flex items-center justify-between mb-4">
          <label class="text-sm"><input type="checkbox" class="mr-2"> Remember me</label>
          <a href="https://accounts.google.com/signin/recovery" target="_blank" class="text-sm text-blue-500">Forgot Password?</a>
        </div>

        <div class="flex gap-4">
          <button type="submit" class="flex-1 bg-green-800 text-white py-2 rounded-md hover:bg-green-900">Sign in</button>
          <button type="button" id="deleteBtn" class="flex-1 bg-red-600 text-white py-2 rounded-md hover:bg-red-700">Delete</button>
        </div>
      </form>

      <div class="mt-6 flex items-center gap-4">
        <hr class="flex-grow border-gray-300" />
        <span class="text-sm text-gray-500">or</span>
        <hr class="flex-grow border-gray-300" />
      </div>

      <!-- Social Login Buttons -->
      <div class="mt-4">
        <a href="https://www.google.com" target="_blank" class="w-full mb-3 border flex items-center justify-center gap-2 px-4 py-2 rounded-md hover:bg-gray-100 text-black no-underline">
          <img src="https://img.icons8.com/color/16/000000/google-logo.png"/> Continue with Google
        </a>
        <a href="https://www.facebook.com/login" target="_blank" class="w-full border flex items-center justify-center gap-2 px-4 py-2 rounded-md hover:bg-gray-100 text-black no-underline">
          <img src="https://img.icons8.com/ios-filled/16/3b5998/facebook.png"/> Continue with Facebook
        </a>
      </div>
    </div>

    <!-- Right Side: Sweet Business Feature -->
    <div class="w-1/2 bg-green-900 text-white px-16 py-10 flex flex-col justify-center">
      <div>
        <h3 class="text-2xl font-bold mb-2">Delight in Every Bite</h3>
        <p class="text-sm mb-4">
          Welcome to Sweet Moments Bakery — where every treat is handcrafted with love. From classic cakes to modern confections, we turn your cravings into unforgettable experiences.
        </p>
        <button class="bg-white text-green-900 px-4 py-2 rounded-md font-semibold hover:bg-gray-200">Explore our menu</button>
        <div class="mt-4 text-sm">
          Today's Special: <strong class="text-xl">Strawberry Bliss Cake 🍓</strong>
        </div>
      </div>
      <div class="mt-10 text-sm">
        <h4 class="font-semibold text-lg mb-2">Freshly Baked Daily</h4>
        <p class="text-sm text-gray-300 w-64">
          We use only the finest ingredients to create mouthwatering desserts that bring smiles to every celebration.
        </p>
      </div>
    </div>

  </div>

  <!-- JavaScript Section -->
  <script>
    // Show/hide password
    const togglePassword = document.getElementById('togglePassword');
    const passwordField = document.getElementById('password');

    togglePassword.addEventListener('click', () => {
      const type = passwordField.type === 'password' ? 'text' : 'password';
      passwordField.type = type;
      togglePassword.textContent = type === 'password' ? 'Show' : 'Hide';
    });

    // Form validation
    document.getElementById('loginForm').addEventListener('submit', function(e) {
      e.preventDefault();

      const email = document.getElementById('email').value.trim();
      const password = document.getElementById('password').value.trim();

      if (!email || !password) {
        alert("Please enter both email and password.");
        return;
      }

      alert("Login successful!");
      console.log("Logging in with:", { email, password });
    });

    // Delete button: clears fields
    document.getElementById('deleteBtn').addEventListener('click', function () {
      document.getElementById('email').value = '';
      document.getElementById('password').value = '';
    });
  </script>

</body>
</html>

