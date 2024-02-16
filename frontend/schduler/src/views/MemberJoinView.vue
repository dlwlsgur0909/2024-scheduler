<script setup>
import { ref } from 'vue';
import axios from 'axios';

const memberName = ref('');
const memberEmail = ref('');
const memberPassword = ref('');
const memberNickname = ref('');


function registerMember() {

  const registerData = {
    memberName: memberName.value,
    memberEmail: memberEmail.value,
    memberPassword: memberPassword.value,
    memberNickname: memberNickname.value
  };

  axios.post(`http://localhost:8080/members`, registerData)
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
        <div class="register-form-container">
            <div class="input-item">
                <span>이름</span>
                <input type="text" v-model="memberName">
            </div>
            <div class="input-item">
                <span>이메일</span>
                <input type="text" v-model="memberEmail">
            </div>
            <div class="input-item">
                <span>비밀번호</span>
                <input type="text" v-model="memberPassword">
            </div>
            <div class="input-item">
                <span>닉네임</span>
                <input type="text" v-model="memberNickname">
            </div>
      </div>
      
      <div class="footer">
                <button type="button" @click="registerMember()">
                    회원가입
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

.register-form-container {
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