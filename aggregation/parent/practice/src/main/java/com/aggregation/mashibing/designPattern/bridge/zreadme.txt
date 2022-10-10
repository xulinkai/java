

桥接模式

抽象和具体两个方向上同时发展，避免使用继承，不会产生类爆炸，



Book extends GiftImpl
Flower extends GiftImpl

abstract class Gift
ColdGift extends Gift
GiftImpl extends Gift
WildFlower extends Gift
