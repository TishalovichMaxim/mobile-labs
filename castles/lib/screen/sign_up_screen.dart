import 'package:flutter/material.dart';

class SignUpScreen extends StatefulWidget {
  const SignUpScreen({super.key});

  @override
  State<SignUpScreen> createState() => _SignUpScreenState();
}

class _SignUpScreenState extends State<SignUpScreen> {
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
              const Text(
                "Credentials",
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

              TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  hintText: "Confirm password..."
                ),
              ),

              Divider(),

              const Text(
                "Personal info",
                style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24),
              ),

              TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  hintText: "Input your first name"
                ),
              ),

              TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  hintText: "Input your last name"
                ),
              ),

              TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  hintText: "Write something about yourself"
                ),
              ),

              const Divider(),

              InkWell(
                child: const Text(
                  "Already have an account?",
                  style: TextStyle(decoration: TextDecoration.underline),
                ),
                onTap: () {
                  Navigator.pushNamed(context, "/sign_in");
                },
              ),

              ElevatedButton(
                child: Text("Go"),
                onPressed: () {
                },
              )
            ],
          ),
        )
      ),
    );
  }
}