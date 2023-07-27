/* eslint-disable no-console */
import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";

const AppResult = () => {
  const location = useLocation();
  const sendAnswers = location.state.answers;
  const [value, setValue] = useState("");

  useEffect(() => {
    console.log("컴포넌트가 화면에 나타남 ", sendAnswers);
    fetch("http://52.78.118.174:8080/api/answer", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(sendAnswers), // survey 에서 받아온 데이터를 넘겨줌(라우터)
    })
      .then((res) => {
        if (res.ok) {
          console.log(">> " + res.status);
          return res.json();
        } else {
          return null;
        }
      })
      .then((res) => {
        setValue(res.data);
      });
  }, [sendAnswers, setValue]);
  const style = {
    result: {
      textAlign: "center",
      paddingTop: "300px",
    },
    test: {
      color: "white",
      display: "inline-block",
      fontSize: "100px",
    },
    test2: {
      color: "white",
      fontSize: "100px",
      marginBottom: "30px",
    },
  };

  return (
    <div style={style.result}>
      <div style={style.test2}>추천 OTT 는</div>
      <div style={style.test}>{value} 입니다.</div>
    </div>
  );
};

export default AppResult;
