import React from "react";

const AppResult = () => {
  const style = {
    result: {
      textAlign: "center",
    },
    test: {
      backgroundColor: "red",
      display: "inline-block",
    },
    test2: {
      backgroundColor: "yellow",
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
