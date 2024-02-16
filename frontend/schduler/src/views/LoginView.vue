<script setup>
import { ref } from 'vue';

const memberEmail = ref('');
const memberPassword = ref('');


function login() {

    const loginData = {
        memberEmail,
        memberPassword
    };

    axios.post('http://localhost:8080/members/login', loginData)
    .then((res) => {
        console.log(res);
    })
    .catch((error) => {
        console.log(error);
    })

}

</script>

<template>
    <div class="container">
        <div class="login-form-container">
            <div class="input-item">
                <span>이메일</span>
                <input type="text" v-model="memberEmail">
            </div>
            <div class="input-item">
                <span>비밀번호</span>
                <input type="text" v-model="memberPassword">
            </div>
      </div>
      
      <div class="footer">
                <button type="button" @click="registerMember()">
                    로그인
                </button>
      </div>
    </div>
</template>

<style scoped>

.container {
    display: flex;
    flex-direction: column;
    gap: 30px;
}

.login-form-container {
  display: flex;
  flex-wrap: wrap;
}

.input-item {
  display: flex;
  justify-content: space-between;
  width: 100%;
}

.footer {
  display: flex;
  justify-content: flex-end;
}


</style>