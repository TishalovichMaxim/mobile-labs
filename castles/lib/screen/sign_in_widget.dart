import 'package:flutter/material.dart';

class SignInScreen extends StatefulWidget {
  const SignInScreen({super.key});

  @override
  State<SignInScreen> createState() => _SignInScreenState();
}

void signIn() {
  print("Sign in!");
}

class _SignInScreenState extends State<SignInScreen> {
  TextEditingController myController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
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
              ElevatedButton(
                onPressed: signIn,
                child: Text("Go")
              )
            ],
          ),
        )
      ),
    );
  }
}
