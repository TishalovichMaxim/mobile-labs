import 'package:flutter/material.dart';

class SignInScreen extends StatefulWidget {
  const SignInScreen({super.key});

  @override
  State<SignInScreen> createState() => _SignInScreenState();
}

class _SignInScreenState extends State<SignInScreen> {
  TextEditingController myController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Padding(
          padding: EdgeInsets.all(20.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                "Sign in",
                style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24),
              ),
              TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  hintText: "Email..."
                ),
              ),
              TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  hintText: "Password..."
                ),
              ),
              InkWell(
                child: 
                  Text(
                    "Have no account?",
                    style: TextStyle(decoration: TextDecoration.underline),
                  ),
                onTap: () {
                  Navigator.pushNamed(context, "/sign_up");
                },
              ),
              ElevatedButton(
                onPressed: () {
                  Navigator.pushNamed(context, "/castles");
                },
                child: Text("Go")
              )
            ],
          ),
        )
      ),
    );
  }
}
