import 'package:castles/model/castle.dart';
import 'package:castles/screen/castle_preview.dart';
import 'package:flutter/material.dart';

class CastlesScreen extends StatefulWidget {
  const CastlesScreen({super.key});

  @override
  State<CastlesScreen> createState() => _CastlesScreenState();
}

class _CastlesScreenState extends State<CastlesScreen> {
  @override
  Widget build(BuildContext context) {
    var castles = [
      Castle("1", "Mir Castle", "Belarus", 1234, "https://buffer.com/library/content/images/2023/10/free-images.jpg"),
      Castle("1", "Nesvizh", "Belarus", 1234, "https://buffer.com/library/content/images/2023/10/free-images.jpg"),
      Castle("1", "Dark Castle", "Belarus", 1234, "https://buffer.com/library/content/images/2023/10/free-images.jpg"),
    ];

    return Scaffold(
      body:
          ListView.builder(itemCount: castles.length + 1, itemBuilder: (context, index) {
              if (index == 0) {
                return Container(
                  alignment: Alignment.center,
                  child: const Text(
                    "Castles of the world!",
                    style: TextStyle(
                      fontSize: 26,
                      fontWeight: FontWeight.bold
                    ),
                  ),
                );
              }

              index -= 1;

              return CastlePreview(castle: castles[index]);
            }
          ),
      );
  }
}