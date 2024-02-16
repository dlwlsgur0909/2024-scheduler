<script setup>
import { ref } from 'vue';
import axios from 'axios';

const memberEmail = ref('');
const memberPassword = ref('');


function login() {

    const loginData = {
        memberEmail,
        memberPassword
    };

    axios.post('http://localhost:8080/members/login', loginData)
    .then((res) => {
        if(res.status === 200) {
            window.alert('환영합니다!');
            console.log(res);
        }
    })
    .catch((error) => {
        
        if(error.response.data === 'Login Failed') {
            window.alert('이메일 혹은 비밀번호를 확인해주세요')
        }
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
                <button type="button" @click="login()">
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