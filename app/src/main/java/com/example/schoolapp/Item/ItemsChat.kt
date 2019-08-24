package com.example.schoolapp.Item

class ItemsChat {
    var userId: Int
    var tempMes: String?
    var  unReadMes: String?
    var lastMesTime: String?

    constructor(id: Int, tempMes: String?, numOfUnread: String?, lastTime: String?){
        this.userId = id
        this.tempMes = tempMes
        this.unReadMes = numOfUnread
        this.lastMesTime = lastTime
    }
}