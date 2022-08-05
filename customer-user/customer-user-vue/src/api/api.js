import axios from "axios";


// 注册
function register(
    name,
    phone,
    grade,
    password
) {
    return axios.post("http://localhost:9999//user/register", {
        name: name,
        phone: phone,
        grade: grade,
        password: password,

    })
}

// 用户列表
function getUserList(cur, size, curUserId) {
    return axios.get("http://localhost:9999/user/page/" + cur + "/" + size + "/" + curUserId);

}

// 关注
function follower(userId,
                  opUserId) {
    return axios.post("http://localhost:9999/user/operation/white",
        {
            userId: userId,
            opUserId: opUserId
        })

}

// 取消关注
function cancelFollower(userId,
                        opUserId) {
    return axios.post("http://localhost:9999/user/operation/white/remove",
        {
            userId: userId,
            opUserId: opUserId
        })
}


// 拉黑
function black(userId,
               opUserId) {
    return axios.post("http://localhost:9999/user/operation/black",
        {
            userId: userId,
            opUserId: opUserId
        })

}

// 取消拉黑
function cancelBlack(userId,
                     opUserId) {
    return axios.post("http://localhost:9999/user/operation/black/remove",
        {
            userId: userId,
            opUserId: opUserId
        })
}


export {
    getUserList,
    register,
    follower,
    cancelFollower,
    black,
    cancelBlack,
}
