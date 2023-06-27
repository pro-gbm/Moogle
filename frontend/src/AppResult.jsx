/* eslint-disable no-console */
import React, { useEffect } from "react";
import { useLocation } from "react-router-dom";

const AppResult = () => {
  useEffect(() => {
    console.log("컴포넌트가 화면에 나타남");
    fetch("http://52.78.118.174:8080/api/answer", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: {
        // survey 에서 받아온 데이터를 넘겨줌(라우터)
        actors: [20],
        directors: [1],
        genres: [28],
        movies: [2553],
      },
    }).then((res) => {
      alert("데이터가 잘 넘어갔습니다.");
      console.log("res = ", res);
    });
    return () => {
      console.log("컴포넌트가 화면에서 사라짐");
    };
  }, []);
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
  const result = [
    {
      id: 1,
      ott: "Netflix",
    },
    {
      id: 2,
      ott: "Watcha",
    },
  ];

  return (
    <div style={style.result}>
      <div style={style.test2}>추천 OTT 는</div>
      <div style={style.test}>{result[0].ott} 입니다.</div>
    </div>
  );
};

export default AppResult;
