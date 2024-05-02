import 'package:castles/screen/castles_screen.dart';
import 'package:castles/screen/favorites_screen.dart';
import 'package:castles/screen/profile_screen.dart';
import 'package:flutter/material.dart';

class AppScreen extends StatefulWidget {
  AppScreen({super.key});

  @override
  State<AppScreen> createState() => _AppScreenState();
}

class _AppScreenState extends State<AppScreen> {

  int _screenIndex = 0;

  chooseScreen(int screenIndex) {
    setState(() {
      _screenIndex = screenIndex;
    });
  }

  final List _screens = [
    ProfileScreen(),
    CastlesScreen(),
    FavoritesScreen()
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _screens[_screenIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _screenIndex,
        onTap: chooseScreen,
        items: [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home'
          ),

          BottomNavigationBarItem(
            icon: Icon(Icons.castle),
            label: 'Castles'
          ),

          BottomNavigationBarItem(
            icon: Icon(Icons.favorite),
            label: 'Favorites'
          ),
        ],
      )
    );
  }
}
