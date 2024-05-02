import 'package:castles/model/user.dart';
import 'package:flutter/material.dart';

class ProfileScreen extends StatefulWidget {
  const ProfileScreen({super.key});

  @override
  State<ProfileScreen> createState() => _ProfileScreenState();
}

class _ProfileScreenState extends State<ProfileScreen> {
  @override
  Widget build(BuildContext context) {
    var user = User("tishalovichm@gmail.com", "Maxim", "Tishalovich", "BSUIR student", DateTime(2004));

    return Scaffold(
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Text(
                "Profile",
                style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24),
              ),
              Text(
                user.email,
                style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 24),
              ),
              Text(
                "${user.firstName} ${user.lastName}",
                style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 24),
              ),
              Text(
                "${user.birthdate.day}.${user.birthdate.month}.${user.birthdate.year}",
                style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 24),
              ),
              const ElevatedButton(
                onPressed: null,
                style:
                  ButtonStyle(backgroundColor: MaterialStatePropertyAll(Color.fromARGB(255, 255, 0, 0))),
                child: 
                  Text(
                    "Logout",
                    style: TextStyle(color: Color.fromARGB(255, 255, 255, 255)),
                  ),
              ),
            ],
          ),
        )
      ),
    );
  }
}
