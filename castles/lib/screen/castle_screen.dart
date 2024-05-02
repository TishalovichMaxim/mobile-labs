import 'package:castles/model/castle.dart';
import 'package:flutter/material.dart';

class CastleScreen extends StatefulWidget {
  const CastleScreen({super.key});

  @override
  State<CastleScreen> createState() => _CastleScreenState();
}

class _CastleScreenState extends State<CastleScreen> {



  @override
  Widget build(BuildContext context) {
    var castle = Castle("1", "Mir Castle", "Belarus", 1234, "https://buffer.com/library/content/images/2023/10/free-images.jpg");

    return Scaffold(
      body: Center(
        child: Column(
          children: [
            Text(
              castle.name,
              style: const TextStyle(fontSize: 24),
            ),
            Image.network(castle.mainImage),
            Text("Country: ${castle.country}"),
            Text("Foundation year: ${castle.foundationYear}"),
          ]
        )
      ),
    );
  }
}