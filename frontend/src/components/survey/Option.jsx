/** @jsxImportSource @emotion/react */
import { css } from "@emotion/react";

const option = css({
  color: "#FFF",
  border: "1px solid #FFF",
  borderRadius: "10px",
  height: "2.5rem",
  marginLeft: "15%",
  marginRight: "15%",
  marginTop: "15px",
  marginBottom: "20px",
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
  backgroundColor: "rgba(27, 18, 15, 0.25)",
  cursor: "pointer",
  transition: "box-shadow 0.2s ease-out",
  "&:hover": {
    boxShadow: "inset 0 0 100px 100px rgba(255,255,255,0.1)",
  },
});

function Option(props) {
  const { data } = props;

  return <div css={option}>{data}</div>;
}

export default Option;
