# 111 Hotel

Android app (Java + XML) for Assignment 2 – Android Application Development.
Reg No: 24108111

A simple fast-food ordering style app inspired by restaurant apps.

## Screens / Features
- **Splash** – shows the 111 logo and app name, opens Login after 2 seconds.
- **Login** – email + password with validation. Links to Register and Forgot Password.
- **Register** – name, email, password, confirm password with validation (valid email, min 6 chars, passwords match).
- **Forgot Password** – enter email, simulated recovery code is "sent".
- **Reset Password** – new password + confirm password with validation.
- **Home** – banner and menu modules (Buckets, Burgers, Snacks, Drinks, Deals, Profile) shown as cards in a grid.
- **Profile** – shows user name and email, Logout button.

Default login: `admin@111.com` / `123456` (or register a new account). Data is saved locally with SharedPreferences, no backend.

## Navigation Flow
```
Splash -> Login -> Home -> Profile -> Logout -> Login
          Login -> Register -> Login
          Login -> Forgot Password -> Reset Password -> Login
```

## Technical Points
- Resources: `values/strings.xml`, `values/colors.xml` and `values-night/colors.xml` for dark mode.
- Layouts: LinearLayout (Login, Register, Forgot, Reset, Profile), GridLayout (Home menu), ConstraintLayout (Splash, Home).
- Input types: `textPersonName`, `textEmailAddress`, `textPassword`.
- Button clicks and input validation in every form.
- Explicit Intents used for all navigation.
