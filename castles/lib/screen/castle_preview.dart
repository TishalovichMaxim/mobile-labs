import 'package:castles/model/castle.dart';
import 'package:flutter/material.dart';

class CastlePreview extends StatelessWidget {
  final Castle castle;

  const CastlePreview({required this.castle});

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: () => Navigator.pushNamed(context, '/castle'),
      child: Column(
        children: [
          Image.network(castle.mainImage),
          Text(
            castle.name,
            style: const TextStyle(fontSize: 26),
          )
        ],
      ),
    );
  }
}