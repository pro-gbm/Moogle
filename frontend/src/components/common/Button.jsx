import { useEffect, useState } from 'react';

/////////////// Type
// color: default, disabled, warning
// variant: outlined, filled
// size: small, medium, large
// value: any string
// icon: icon component
// iconPosition: front, back

export default function Button(props) {
  const { color, size, value, variant, iconPosition } = props;
  const Icon = props.icon;

  const parseProps = () => {
    let text_color = '';
    let border_color = '';
    let bg_color = '';
    let padding = 0;
    let font_size = 0;
    let border_radius = 0;

    switch (size) {
      case 'small':
        padding = 5;
        font_size = 12;
        border_radius = 8;
        break;
      case 'medium':
        padding = 8;
        font_size = 17;
        border_radius = 10;
        break;
      case 'large':
        padding = 10;
        font_size = 22;
        border_radius = 12;
        break;
      default:
        padding = 8;
        font_size = 22;
        border_radius = 12;
    }

    switch (variant) {
      case 'outlined':
        if (color === 'warning') {
          text_color = '#E2202C';
          border_color = '#E2202C';
          bg_color = '#FFFFFF';
        } else if (color === 'disabled') {
          text_color = '#D9D9D9';
          border_color = '#D9D9D9';
          bg_color = '#FFFFFF';
        } else {
          text_color = '#ffcb00';
          border_color = '#ffcb00';
          bg_color = '#FFFFFF';
        }
        break;
      case 'filled':
        if (color === 'warning') {
          text_color = '#FFFFFF';
          border_color = '#E2202C';
          bg_color = '#E2202C';
        } else if (color === 'disabled') {
          text_color = '#FFFFFF';
          border_color = '#D9D9D9';
          bg_color = '#D9D9D9';
        } else {
          text_color = '#FFFFFF';
          border_color = '#ffcb00';
          bg_color = '#ffcb00';
        }
        break;
      default:
        text_color = '#FFFFFF';
        border_color = '#FFFFFF';
        bg_color = '#FFFFFF';
    }

    return {
      text_color: text_color,
      border_color: border_color,
      bg_color: bg_color,
      padding: padding,
      font_size: font_size,
      border_radius: border_radius,
    };
  };

  const [feature, setFeature] = useState({
    text_color: '#FFFFFF',
    border_color: '#FFFFFF',
    bg_color: '#FFFFFF',
    padding: 8,
    font_size: 22,
    border_radius: 12,
  });

  useEffect(() => {
    setFeature({
      ...feature,
      text_color: parseProps().text_color,
      border_color: parseProps().border_color,
      bg_color: parseProps().bg_color,
    });
  }, [variant, color]);

  return (
    <div
      className="icon-wrapper"
      style={{
        backgroundColor: feature.bg_color,
        border: `2px solid ${feature.border_color}`,
        color: feature.text_color,
        padding: `${feature.padding}px`,
        paddingLeft: `calc(${feature.padding}px + 10px)`,
        paddingRight: `calc(${feature.padding}px + 10px)`,
        fontSize: `${feature.font_size}px`,
        borderRadius: `${feature.border_radius}px`,
        width: 'fit-content',
        whiteSpace: 'nowrap',
        fontWeight: 'bold',
        cursor: color !== 'disabled' ? 'pointer' : 'default',
        display: 'flex',
        alignItems: 'center',
        '&:hover': {
          boxShadow: color !== 'disabled' ? '1px 2px 3px #DDD' : undefined,
          transition: 'box-shadow 0.2s ease-out',
        },
      }}
    >
      {iconPosition === 'front' && Icon && (
        <div style={{ paddingRight: '5px' }}>
          <Icon fontSize="small" sx={{ cursor: 'inherit' }} />
        </div>
      )}
      {value.toUpperCase()}
      {iconPosition === 'back' && Icon && (
        <div style={{ paddingLeft: '5px' }}>
          <Icon fontSize="small" sx={{ cursor: 'inherit' }} />
        </div>
      )}
    </div>
  );
}
